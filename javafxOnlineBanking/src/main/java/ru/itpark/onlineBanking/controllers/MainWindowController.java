package ru.itpark.onlineBanking.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.itpark.onlineBanking.app.OnlineBankingRestTemp;
import ru.itpark.onlineBanking.models.AccountTransaction;
import ru.itpark.onlineBanking.models.User;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class MainWindowController {

    private List transactionsData;

    private OnlineBankingRestTemp onlineBankingRestTemp = new OnlineBankingRestTemp();

    private User user;

    @FXML
    private TableView<AccountTransaction> tableTransactions;

    @FXML
    private TableColumn<AccountTransaction, Date> date;

    @FXML
    private TableColumn<AccountTransaction, String> description;

    @FXML
    private TableColumn<AccountTransaction, String> type;

    @FXML
    private TableColumn<AccountTransaction, String> status;

    @FXML
    private TableColumn<AccountTransaction, Double> amount;

    @FXML
    private TableColumn<AccountTransaction, BigDecimal> availableBalance;

    private void initialize() {
        // устанавливаем тип и значение которое должно хранится в колонке
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        availableBalance.setCellValueFactory(new PropertyValueFactory<>("availabelBalance"));

        // заполняем таблицу данными
        tableTransactions.setItems((ObservableList<AccountTransaction>) transactionsData);
    }

    private void initData(List accountTransactionList) {
        transactionsData = accountTransactionList;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @FXML
    public void primaryTransaction() {
        initData(onlineBankingRestTemp.primaryTransactionList(user));
    }

    @FXML
    public void savingsTransaction() {
        initData(onlineBankingRestTemp.savingsTransactionList(user.getUserId()));
    }
}
