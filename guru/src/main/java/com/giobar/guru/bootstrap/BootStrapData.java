package com.giobar.guru.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.giobar.guru.domain.Author;
import com.giobar.guru.domain.Book;
import com.giobar.guru.domain.Publisher;
import com.giobar.guru.repository.AuthorRepository;
import com.giobar.guru.repository.BookRepository;
import com.giobar.guru.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Started in Bootstrap");
		
		Publisher publisher = new Publisher();
		publisher.setName("Feltrinelli");
		publisher.setCity("Torino");
		publisher.setState("Italy");
		publisherRepository.save(publisher);
		
		Author andrea = new Author("Andrea", "Camilleri");
		Book mossa = new Book("La mossa del cavallo", "12345678");
		andrea.getBooks().add(mossa);
		
		mossa.getAuthors().add(andrea);
		mossa.setPublisher(publisher);
		
		publisher.getBooks().add(mossa);
		
		authorRepository.save(andrea);
		bookRepository.save(mossa);
		
		Author lucy = new Author("Luciana", "Litizzetto");
		Book sedano = new Book("Come un gambo di sedano", "9988777");
		
		lucy.getBooks().add(sedano);
		sedano.getAuthors().add(lucy);
		sedano.setPublisher(publisher);
		publisher.getBooks().add(sedano);
		
		authorRepository.save(lucy);
		bookRepository.save(sedano);
		publisherRepository.save(publisher);
		
		System.out.println("Publisher count " + publisherRepository.count());
		System.out.println("Number of books " + bookRepository.count());
		System.out.println("Publisher Number of books " + publisher.getBooks().size());

	}

}
