package guru.spring.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.spring.spring5webapp.domain.Author;
import guru.spring.spring5webapp.domain.Book;
import guru.spring.spring5webapp.domain.Publisher;
import guru.spring.spring5webapp.repositories.AuthorRepository;
import guru.spring.spring5webapp.repositories.BookRepository;
import guru.spring.spring5webapp.repositories.PublisherRepository;


@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepo;
	private final BookRepository bookRepo;
	private final PublisherRepository pubRepo;
	
	
	public BootStrapData(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository pubRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.pubRepo = pubRepo;
	}


	@Override
	public void run(String... args) throws Exception {
		
		Publisher pub = new Publisher();
		pub.setName("Zobert Pub");
		pub.setAddress("4th ST N");
		pub.setCity("Arlington");
		pub.setState("VA");
		pub.setZip("22204");
		pubRepo.save(pub);
		System.out.println("Pubs count: " + pubRepo.count());

		
		Author auth1 = new Author("Eric", "Evans");
		Book book1 = new Book("Domain Driven Design", "123123");
		auth1.getBooks().add(book1);
		book1.getAuthors().add(auth1);
		book1.setPublisher(pub);
		pub.getBooks().add(book1);
		
		authorRepo.save(auth1);
		bookRepo.save(book1);
		pubRepo.save(pub);
				
		
		Author auth2 = new Author("Rod", "Johnson");
		Book book2 = new Book("J2EE Development without EJB", "333444555");
		auth2.getBooks().add(book2);
		book2.getAuthors().add(auth2);
		book2.setPublisher(pub);
		pub.getBooks().add(book2);
		
		authorRepo.save(auth2);
		bookRepo.save(book2);
		pubRepo.save(pub);
		
		System.out.println("Book count: " + bookRepo.count());
		System.out.println("Pub # books: " + pub.getBooks().size());
	}

}

