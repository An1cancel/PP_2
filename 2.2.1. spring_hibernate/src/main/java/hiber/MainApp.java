package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Name1", "LastName1", "kyst@gmail.com"), new Car("BMW", 2024));
        userService.add(new User("Name2", "LastName2", "gyst@gmail.com"), new Car("Lada", 2021));
        userService.add(new User("Name3", "LastName3", "xyst@gmail.com"), new Car("Lada", 2021));


        List<User> users = userService.carUser("Lada", 2021);
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Mobile = " + user.getCarId().getModel());
            System.out.println("Series = " + user.getCarId().getSeries());
            System.out.println();
        }

        context.close();
    }
}
