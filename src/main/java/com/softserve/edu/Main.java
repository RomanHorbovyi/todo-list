package com.softserve.edu;

import com.softserve.edu.entities.Dashboard;
import com.softserve.edu.entities.Task;
import com.softserve.edu.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Collections;

/**
 * Created by Roman on 30.10.2015.
 *
 */

public class Main {
    public static void main(String[] args) {

        // bootstrapping Hibernate
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
            .configure().build();
        Metadata metadata = new MetadataSources(standardServiceRegistry)
                .getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        // starting session
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // creating user 1
        User user1 = new User("login", "email", "password");
        user1.setFirstName("John");
        user1.setLastName("Smith");

        // creating user 2
        User user2 = new User("login2", "email2", "password2");
        user2.setFirstName("Darth");
        user2.setLastName("Vader");

        // creating first task
        Task task1 = new Task();
        task1.setAssignee(user2);
        task1.setDescription("description");
        task1.setName("name");

        // creating second task (subtask of the 1st task)
        Task task2 = new Task();
        task2.setAssignee(user2);
        task2.setDescription("description2");
        task2.setName("name2");
        task2.setParrent(task1);

        // creating 3rd task
        Task task3 = new Task();
        task3.setAssignee(user1);
        task3.setDescription("description3");
        task3.setName("name3");

        // creating dashboard
        Dashboard dashboard = new Dashboard();
        dashboard.setName("NAME");
        dashboard.setDescription("DESCRIPTION");
        dashboard.setAuthor(user1);
        Collections.addAll(dashboard.getTaskList(), task1, task2, task3);
        Collections.addAll(dashboard.getAssignedList(), task1.getAssignee(), task2.getAssignee(),
                task3.getAssignee());

        // assigning tasks to dashboard (because of bidirectional association
        task1.setDashboard(dashboard);
        task2.setDashboard(dashboard);
        task3.setDashboard(dashboard);

        // persisting objects
        session.save(user1);
        session.save(user2);
        session.save(dashboard);
        session.save(task1);
        session.save(task2);
        session.save(task3);

        // closing everything
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
