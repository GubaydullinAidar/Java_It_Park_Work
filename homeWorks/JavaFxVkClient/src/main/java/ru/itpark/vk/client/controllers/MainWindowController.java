package ru.itpark.vk.client.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ru.itpark.vk.api.core.ApiBuilder;
import ru.itpark.vk.api.core.VkApi;
import ru.itpark.vk.models.Friend;

import java.util.List;

public class MainWindowController {

    private VkApi vkApi;

    @FXML
    private TextField id;

    @FXML
    private TextField count;

    @FXML
    private TextField friendsList;

    @FXML
    public void onClickMethod() {
        int idHuman = Integer.parseInt(id.getText());
        int countFriend = Integer.parseInt(count.getText());
        vkApi = ApiBuilder.buildRestTemplateApi();
        List<Friend> friends = vkApi.getUserFriends(idHuman, countFriend, "firstName", "lastName");
        String friendsText ="";
        for (Friend friend : friends) {
            friendsText = friendsText + friend.getFirstName() + " " + friend.getLastName() + "; ";
        }

        friendsList.setText(friendsText);
    }
}
