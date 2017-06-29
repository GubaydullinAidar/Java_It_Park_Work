package ru.itpark.converters;

import ru.itpark.dto.UserDto;
import ru.itpark.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static UserDto convert(User model) {
        return new UserDto(model.getUserId(), model.getFirstName(), model.getLastName(), model.getEmail(), model.getPhone());
    }

    public static List<UserDto> convert(List<User> models) {
        return models.stream()
                .map(user -> convert(user)).collect(Collectors.toList());
    }
}
