package a.vkube.controller;

import a.vkube.daoimpl.*;
import a.vkube.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EditOrderWindow {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    ObservableList<Order> observableList = FXCollections.observableArrayList();
    ObservableList<Status> statusObservableList = FXCollections.observableArrayList();
    ObservableList<Tariff> tariffObservableList = FXCollections.observableArrayList();
    ObservableList<DepartureLocation> departureLocationObservableList = FXCollections.observableArrayList();
    ObservableList<DestinationLocation> destinationLocationObservableList = FXCollections.observableArrayList();
    ObservableList<Dispather> dispatherObservableList = FXCollections.observableArrayList();
    OrderDaoImpl orderDao = new OrderDaoImpl(factory);
    StatusDaoImpl statusDao = new StatusDaoImpl(factory);
    TariffDaoImpl tariffDao = new TariffDaoImpl(factory);
    DepartureLocationDaoImpl departureLocationDao = new DepartureLocationDaoImpl(factory);
    DestinationLocationDaoImpl destinationLocationDao = new DestinationLocationDaoImpl(factory);
    DispatherDaoImpl dispatherDao = new DispatherDaoImpl(factory);

    @FXML
    private TextField txtDateOfReceipt;

    @FXML
    private TextField txtDateOfAppoint;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtCost;

    @FXML
    private ComboBox<DepartureLocation> comboIdDeparture;

    @FXML
    private ComboBox<DestinationLocation> comboIdDestination;

    @FXML
    private ComboBox<Status> comboStatus;

    @FXML
    private ComboBox<Tariff> comboTariff;

    @FXML
    private ComboBox<Dispather> comboDispather;

    @FXML
    private Button buttonBack;

    @FXML
    void initialize(){
        initData();
    }

    @FXML
    void initData(){
        statusObservableList.addAll(statusDao.findByAll());
        tariffObservableList.addAll(tariffDao.findByAll());
        departureLocationObservableList.addAll(departureLocationDao.findByAll());
        destinationLocationObservableList.addAll(destinationLocationDao.findByAll());
        observableList.addAll(orderDao.findByAll());
        dispatherObservableList.addAll(dispatherDao.findByAll());

        comboStatus.setItems(statusObservableList);
        comboTariff.setItems(tariffObservableList);
        comboIdDeparture.setItems(departureLocationObservableList);
        comboIdDestination.setItems(destinationLocationObservableList);
        comboDispather.setItems(dispatherObservableList);
    }
    @FXML
    void actionBack(ActionEvent event) {
        buttonBack.getScene().getWindow().hide();
    }
}