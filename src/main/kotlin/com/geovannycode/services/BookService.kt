package com.geovannycode.services

import com.geovannycode.models.Book
import com.geovannycode.models.BookRequest
import com.geovannycode.models.Books
import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.add
import org.ktorm.entity.find
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toSet

class BookService {

    private val database = Database.connect(
        url = "jdbc:postgresql://localhost:5438/postgres",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "postgres",
    )

    fun createBook(bookRequest: BookRequest): Boolean {
        val newBook = Book {
            name = bookRequest.name
        }

        val affectedRecordsNumber =
            database.sequenceOf(Books)
                .add(newBook)

        return affectedRecordsNumber == 1
    }

    fun findAllBooks(): Set<Book> =
        database.sequenceOf(Books).toSet()

    fun findBookById(bookId: Long): Book? =
        database.sequenceOf(Books)
            .find { book -> book.id eq bookId }

    fun updateBookById(bookId: Long, bookRequest: BookRequest): Boolean {
        val foundBook = findBookById(bookId)
        foundBook?.name = bookRequest.name

        val affectedRecordsNumber = foundBook?.flushChanges()

        return affectedRecordsNumber == 1
    }

    fun deleteBookById(bookId: Long): Boolean {
        val foundBook = findBookById(bookId)

        val affectedRecordsNumber = foundBook?.delete()

        return affectedRecordsNumber == 1
    }

}
