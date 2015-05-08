/*
package com.example.library;

import com.example.library.Model.*;
import com.example.library.Repositories.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories
public class SpringDataExampleLibraryApplication {

    public static void main(String[] args) {
	    ConfigurableApplicationContext context = SpringApplication.run(SpringDataExampleLibraryApplication.class, args);

	    CategoryRepository categoryRepository = context.getBean(CategoryRepository.class);
	    ItemRepository itemRepository = context.getBean(ItemRepository.class);

	    // save a couple of categories
	    Category firstCategory = categoryRepository.save(Category.from("Parent Category 1", null, new ArrayList<Item>()));
	    categoryRepository.save(Category.from("Child Category 1", firstCategory, new ArrayList<Item>()));
	    categoryRepository.save(Category.from("Child Category 2", firstCategory, new ArrayList<Item>()));
	    categoryRepository.save(Category.from("Parent Category 2", null, new ArrayList<Item>()));
	    Category secondCategory = categoryRepository.save(Category.from("Parent Category 3", null, new ArrayList<Item>()));
	    categoryRepository.save(Category.from("Child Category 3", secondCategory, new ArrayList<Item>()));
	    categoryRepository.save(Category.from("Child Category 4", secondCategory, new ArrayList<Item>()));
	    categoryRepository.save(Category.from("Child Category 5", secondCategory, new ArrayList<Item>()));

	    // save a couple of items
	    itemRepository.save(Item.from("Item 1", null));
	    itemRepository.save(Item.from("Item 2", firstCategory));
	    itemRepository.save(Item.from("Item 3", firstCategory));
	    itemRepository.save(Item.from("Item 4", secondCategory));
	    itemRepository.save(Item.from("Item 5", secondCategory));
	    itemRepository.save(Item.from("Item 6", secondCategory));

	    AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
	    BookRepository bookRepository = context.getBean(BookRepository.class);

	    Author author = new Author();
	    author.setFirstName("Jane");
	    author.setLastName("Doe");
	    author.setBirthDate(new Date());
	    //authorRepository.save(author);

	    Book book = new Book();
	    book.setTitle("Spring");
	    book.setIsbn("1234567891");
	    book.setNumSells(1000);
	    book.setPublishedDate(new Date());

	    //book.getAuthors().add(author);
	    bookRepository.save(book);

	    author.getBooks().add(book);
	    authorRepository.save(author);


	    BasketBallPlayer basketBallPlayer = new BasketBallPlayer();
	    basketBallPlayer.setNumBaskets(1000000);
	    basketBallPlayer.setName("Michael Jordan");

	    SoccerPlayer soccerPlayer = new SoccerPlayer();
	    soccerPlayer.setName("Messi");
	    soccerPlayer.setNumPenalties(100);


	    BasketballPlayerRepository basketballPlayerRepository = context.getBean(BasketballPlayerRepository.class);
	    SoccerPlayerRepository soccerPlayerRepository = context.getBean(SoccerPlayerRepository.class);

	    basketballPlayerRepository.save(basketBallPlayer);
	    soccerPlayerRepository.save(soccerPlayer);
    }
}
*/