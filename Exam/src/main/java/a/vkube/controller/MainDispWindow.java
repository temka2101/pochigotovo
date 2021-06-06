package a.vkube.controller;

import a.vkube.daoimpl.*;
import a.vkube.model.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;

public class MainDispWindow {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    ObservableList<Order> observableList = FXCollections.observableArrayList();
    ObservableList<Driver> driverObservableList = FXCollections.observableArrayList();
    ObservableList<Status> statusObservableList = FXCollections.observableArrayList();
    ObservableList<Tariff> tariffObservableList = FXCollections.observableArrayList();
    ObservableList<DepartureLocation> departureLocationObservableList = FXCollections.observableArrayList();
    ObservableList<DestinationLocation> destinationLocationObservableList = FXCollections.observableArrayList();
    OrderDaoImpl orderDao = new OrderDaoImpl(factory);
    DriverDaoImpl driverDao = new DriverDaoImpl(factory);
    StatusDaoImpl statusDao = new StatusDaoImpl(factory);
    TariffDaoImpl tariffDao = new TariffDaoImpl(factory);
    DepartureLocationDaoImpl departureLocationDao = new DepartureLocationDaoImpl(factory);
    DestinationLocationDaoImpl destinationLocationDao = new DestinationLocationDaoImpl(factory);

    @FXML
    private TableView<Order> fxTableOrder;

    @FXML
    private TableColumn<Order, Integer> fxIdOrder;

    @FXML
    private TableColumn<Order, LocalDateTime> fxDateOfReceipt;

    @FXML
    private TableColumn<Order, LocalDateTime> fxDateOfAppoint;

    @FXML
    private TableColumn<Order, String> fxPhone;

    @FXML
    private TableColumn<Order, String> fxDeparture;

    @FXML
    private TableColumn<Order, String> fxDestination;

    @FXML
    private TableColumn<Order, String> fxStatus;

    @FXML
    private TableColumn<Order, String> fxTariff;

    @FXML
    private TableColumn<Order, String> fxCost;

    @FXML
    private TableView<Driver> fxTableDriver;

    @FXML
    private TableColumn<Driver, String> fxLastName;

    @FXML
    private TableColumn<Driver, String> fxFirstName;

    @FXML
    private TableColumn<Driver, String> fxStatusDriver;

    @FXML
    private TextField txtDateOfReceipt;

    @FXML
    private TextField txtDateOfAppoint;

    @FXML
    private TextField txtPhone;

    @FXML
    private ComboBox<Status> comboStatus;

    @FXML
    private ComboBox<Tariff> comboTariff;

    @FXML
    private TextField txtCost;

    @FXML
    private TextField txtCityDeparture;

    @FXML
    private TextField txtStreetDeparture;

    @FXML
    private TextField txtHouseDeparture;

    @FXML
    private TextField txtBuildingDeparture;

    @FXML
    private TextField txtEntranceDeparture;

    @FXML
    private TextField txtCityDestination;

    @FXML
    private TextField txtStreetDestination;

    @FXML
    private TextField txtHouseDestination;

    @FXML
    private TextField txtBuildingDestination;

    @FXML
    private TextField txtEntranceDestination;

    @FXML
    private Button buttonNewOrder;

    @FXML
    private Button buttonCancel;

    @FXML
    private Label labelDestinationBuilding;

    @FXML
    private Label labelDestinationEntrance;

    @FXML
    private Label labelDeparture;

    @FXML
    private Label labelDestination;

    @FXML
    private Label labelDestinationCity;

    @FXML
    private Label labelDestinationStreet;

    @FXML
    private Label labelDestinationHouse;

    @FXML
    private Label labelDepartureBuilding;

    @FXML
    private Label labelDepartureEntrance;

    @FXML
    private Label labelDepartureCity;

    @FXML
    private Label labelDepartureStreet;

    @FXML
    private Label labelDepartureHouse;

    @FXML
    private Label labelStatus;

    @FXML
    private Label labelTariff;

    @FXML
    private Label labelCost;

    @FXML
    private Label labelDateOfReceipt;

    @FXML
    private Label labelDateOfAppoint;

    @FXML
    private Label labelPhone;

    @FXML
    private TextField txtVillageDestination;

    @FXML
    private Label labelDestinationVillage;

    @FXML
    private Label labelDepartureVillage;

    @FXML
    private TextField txtVillageDeparture;

    @FXML
    private Button buttonExit;

    @FXML
    private Label labelIdDeparture;

    @FXML
    private Label labelIdDestination;

    @FXML
    private ComboBox<DepartureLocation> comboIdDeparture;

    @FXML
    private ComboBox<DestinationLocation> comboIdDestination;

    @FXML
    private Button buttonNext;

    @FXML
    private Button buttonNewOrders;

    @FXML
    void initialize(){
        initData();

        fxTableOrder.setItems(observableList);

        fxIdOrder.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getOrderID()));
        fxDateOfReceipt.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getDateOfReceipt()));
        fxDateOfAppoint.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getDateOfAppointment()));
        fxPhone.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getPhone()));
        fxDeparture.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getDepartureLocation().getStreet()));
        fxDestination.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getDestinationLocation().getStreet()));
        fxStatus.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getStatus().getName()));
        fxTariff.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getTariff().getName()));
        fxCost.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getCost()));

        fxTableDriver.setItems(driverObservableList);

        fxLastName.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getLastName()));
        fxFirstName.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getFirstName()));
        fxStatusDriver.setCellValueFactory(o -> new SimpleObjectProperty<>(o.getValue().getStatus().getName()));
    }
    @FXML
    void initData(){
        observableList.addAll(orderDao.findByAll());
        driverObservableList.addAll(driverDao.findByAll());
        statusObservableList.addAll(statusDao.findByAll());
        tariffObservableList.addAll(tariffDao.findByAll());
        departureLocationObservableList.addAll(departureLocationDao.findByAll());
        destinationLocationObservableList.addAll(destinationLocationDao.findByAll());
        comboStatus.setItems(statusObservableList);
        comboTariff.setItems(tariffObservableList);
        comboIdDeparture.setItems(departureLocationObservableList);
        comboIdDestination.setItems(destinationLocationObservableList);
    }

    @FXML
    void newOrderAction(ActionEvent event) {
        txtDateOfReceipt.setDisable(false);
        txtDateOfAppoint.setDisable(false);
        txtPhone.setDisable(false);
        txtCityDeparture.setDisable(false);
        txtVillageDeparture.setDisable(false);
        txtStreetDeparture.setDisable(false);
        txtHouseDeparture.setDisable(false);
        txtBuildingDeparture.setDisable(false);
        txtEntranceDeparture.setDisable(false);
        comboStatus.setDisable(false);
        comboTariff.setDisable(false);
        txtCost.setDisable(false);
        txtCityDestination.setDisable(false);
        txtVillageDestination.setDisable(false);
        txtStreetDestination.setDisable(false);
        txtHouseDestination.setDisable(false);
        txtBuildingDestination.setDisable(false);
        txtEntranceDestination.setDisable(false);
        buttonCancel.setDisable(false);
        labelDateOfReceipt.setDisable(false);
        labelDateOfAppoint.setDisable(false);
        labelPhone.setDisable(false);
        labelStatus.setDisable(false);
        labelTariff.setDisable(false);
        labelCost.setDisable(false);
        labelDeparture.setDisable(false);
        labelDepartureCity.setDisable(false);
        labelDepartureVillage.setDisable(false);
        labelDepartureStreet.setDisable(false);
        labelDepartureHouse.setDisable(false);
        labelDepartureBuilding.setDisable(false);
        labelDepartureEntrance.setDisable(false);
        labelDestination.setDisable(false);
        labelDestinationCity.setDisable(false);
        labelDestinationVillage.setDisable(false);
        labelDestinationStreet.setDisable(false);
        labelDestinationHouse.setDisable(false);
        labelDestinationBuilding.setDisable(false);
        labelDestinationEntrance.setDisable(false);
        buttonNext.setDisable(false);
        buttonNewOrders.setDisable(true);
    }
    @FXML
    void cancelAction(ActionEvent event) {
        txtDateOfReceipt.setDisable(true);
        txtDateOfAppoint.setDisable(true);
        txtPhone.setDisable(true);
        txtCityDeparture.setDisable(true);
        txtVillageDeparture.setDisable(true);
        txtStreetDeparture.setDisable(true);
        txtHouseDeparture.setDisable(true);
        txtBuildingDeparture.setDisable(true);
        txtEntranceDeparture.setDisable(true);
        comboStatus.setDisable(true);
        comboTariff.setDisable(true);
        txtCost.setDisable(true);
        txtCityDestination.setDisable(true);
        txtVillageDestination.setDisable(true);
        txtStreetDestination.setDisable(true);
        txtHouseDestination.setDisable(true);
        txtBuildingDestination.setDisable(true);
        txtEntranceDestination.setDisable(true);
        buttonNewOrder.setDisable(true);
        buttonCancel.setDisable(true);
        labelDateOfReceipt.setDisable(true);
        labelDateOfAppoint.setDisable(true);
        labelPhone.setDisable(true);
        labelStatus.setDisable(true);
        labelTariff.setDisable(true);
        labelCost.setDisable(true);
        labelDeparture.setDisable(true);
        labelDepartureCity.setDisable(true);
        labelDepartureVillage.setDisable(true);
        labelDepartureStreet.setDisable(true);
        labelDepartureHouse.setDisable(true);
        labelDepartureBuilding.setDisable(true);
        labelDepartureEntrance.setDisable(true);
        labelDestination.setDisable(true);
        labelDestinationCity.setDisable(true);
        labelDestinationVillage.setDisable(true);
        labelDestinationStreet.setDisable(true);
        labelDestinationHouse.setDisable(true);
        labelDestinationBuilding.setDisable(true);
        labelDestinationEntrance.setDisable(true);
        buttonNewOrders.setDisable(false);
        buttonNext.setDisable(true);
    }

    @FXML
    void exitAction(ActionEvent event) {
        buttonExit.getScene().getWindow().hide();
    }

    @FXML
    void nextAction(ActionEvent event) throws ParseException{
        labelIdDeparture.setDisable(false);
        labelIdDestination.setDisable(false);
        comboIdDeparture.setDisable(false);
        comboIdDestination.setDisable(false);
        buttonCancel.setDisable(true);
        buttonNext.setDisable(true);
        txtDateOfReceipt.setDisable(true);
        txtDateOfAppoint.setDisable(true);
        txtPhone.setDisable(true);
        txtCityDeparture.setDisable(true);
        txtVillageDeparture.setDisable(true);
        txtStreetDeparture.setDisable(true);
        txtHouseDeparture.setDisable(true);
        txtBuildingDeparture.setDisable(true);
        txtEntranceDeparture.setDisable(true);
        comboStatus.setDisable(true);
        comboTariff.setDisable(true);
        txtCost.setDisable(true);
        txtCityDestination.setDisable(true);
        txtVillageDestination.setDisable(true);
        txtStreetDestination.setDisable(true);
        txtHouseDestination.setDisable(true);
        txtBuildingDestination.setDisable(true);
        txtEntranceDestination.setDisable(true);
        buttonCancel.setDisable(true);
        buttonNext.setDisable(true);
        buttonNewOrder.setDisable(false);
        labelDateOfReceipt.setDisable(true);
        labelDateOfAppoint.setDisable(true);
        labelPhone.setDisable(true);
        labelStatus.setDisable(true);
        labelTariff.setDisable(true);
        labelCost.setDisable(true);
        labelDeparture.setDisable(true);
        labelDepartureCity.setDisable(true);
        labelDepartureVillage.setDisable(true);
        labelDepartureStreet.setDisable(true);
        labelDepartureHouse.setDisable(true);
        labelDepartureBuilding.setDisable(true);
        labelDepartureEntrance.setDisable(true);
        labelDestination.setDisable(true);
        labelDestinationCity.setDisable(true);
        labelDestinationVillage.setDisable(true);
        labelDestinationStreet.setDisable(true);
        labelDestinationHouse.setDisable(true);
        labelDestinationBuilding.setDisable(true);
        labelDestinationEntrance.setDisable(true);

        DepartureLocation departureLocation = new DepartureLocation();
            departureLocation.setCity(txtCityDeparture.getText());
            departureLocation.setVillage(txtVillageDeparture.getText());
            departureLocation.setStreet(txtStreetDeparture.getText());
            departureLocation.setHouse(txtHouseDeparture.getText());
            departureLocation.setBuilding(txtBuildingDeparture.getText());
            departureLocation.setEntrance(txtEntranceDeparture.getText());
        DestinationLocation destinationLocation = new DestinationLocation();
            destinationLocation.setCity(txtCityDestination.getText());
            destinationLocation.setVillage(txtVillageDestination.getText());
            destinationLocation.setStreet(txtStreetDestination.getText());
            destinationLocation.setHouse(txtHouseDestination.getText());
            destinationLocation.setBuilding(txtBuildingDestination.getText());
            destinationLocation.setEntrance(txtEntranceDestination.getText());

        departureLocationDao.create(departureLocation);
        destinationLocationDao.create(destinationLocation);
        departureLocationObservableList.addAll(departureLocation);
        destinationLocationObservableList.addAll(destinationLocation);
    }

    @FXML
    void newOrderAction2(ActionEvent event) throws ParseException {
        Order order = new Order();
        order.setDateOfReceipt(LocalDateTime.parse(txtDateOfReceipt.getText()));
        order.setDateOfAppointment(LocalDateTime.parse(txtDateOfAppoint.getText()));
        order.setPhone(txtPhone.getText());
        order.setStatus(comboStatus.getValue());
        order.setTariff(comboTariff.getValue());
        order.setCost(txtCost.getText());
        order.setDepartureLocation(comboIdDeparture.getValue());
        order.setDestinationLocation(comboIdDestination.getValue());

        orderDao.create(order);

        labelIdDeparture.setDisable(true);
        labelIdDestination.setDisable(true);
        comboIdDeparture.setDisable(true);
        comboIdDestination.setDisable(true);
        buttonNext.setDisable(true);
        buttonNewOrder.setDisable(true);
        buttonNewOrders.setDisable(false);

        txtDateOfReceipt.clear();
        txtDateOfAppoint.clear();
        txtPhone.clear();
        comboStatus.setItems(null);
        comboTariff.setItems(null);
        txtCost.clear();
        txtCityDeparture.clear();
        txtVillageDeparture.clear();
        txtStreetDeparture.clear();
        txtHouseDeparture.clear();
        txtBuildingDeparture.clear();
        txtEntranceDeparture.clear();
        txtCityDestination.clear();
        txtVillageDestination.clear();
        txtStreetDestination.clear();
        txtHouseDestination.clear();
        txtBuildingDestination.clear();
        txtEntranceDestination.clear();
        comboIdDeparture.setItems(null);
        comboIdDestination.setItems(null);

        observableList.addAll(order);
    }
    public void setList(ObservableList observableList){
        this.observableList = observableList;
    }
    public void setListDeparture(ObservableList departureLocationObservableList){
        this.departureLocationObservableList = departureLocationObservableList;
    }
    public void setListDestination(ObservableList destinationLocationObservableList){
        this.destinationLocationObservableList = destinationLocationObservableList;
    }
    @FXML
    void actionEdit(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/editOrder.fxml"));
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/view/images/Icon.jpg"));
        stage.setTitle("Редактирование заказа");
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    void editStatusAction(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/editStatusDriver.fxml"));
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/view/images/Icon.jpg"));
        stage.setTitle("Статус водителя");
        stage.setScene(new Scene(root));
        stage.show();
    }
}