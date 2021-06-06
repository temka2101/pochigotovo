package a.vkube.controller;

import a.vkube.daoimpl.StatusDaoImpl;
import a.vkube.model.Order;
import a.vkube.model.Status;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EditStatusDriver {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    ObservableList<Status> statusObservableList = FXCollections.observableArrayList();
    StatusDaoImpl statusDao = new StatusDaoImpl(factory);

    @FXML
    private ComboBox<Status> comboStatus;

    @FXML
    private Button buttonBack;

    @FXML
    void actionBack(ActionEvent event) {
        buttonBack.getScene().getWindow().hide();
    }

    @FXML
    void initialize(){
        initData();
    }

    @FXML
    void initData(){
        statusObservableList.addAll(statusDao.findByAll());
        comboStatus.setItems(statusObservableList);
    }
}