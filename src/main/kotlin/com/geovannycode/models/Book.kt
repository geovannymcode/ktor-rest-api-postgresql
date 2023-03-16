package com.geovannycode.models

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.long
import org.ktorm.schema.varchar

interface Book : Entity<Book> {
    companion object : Entity.Factory<Book>()

    val id: Long?
    var name: String
}

object Books : Table<Book>("book") {
    val id = long("id").primaryKey().bindTo(Book::id)
    val name = varchar("name").bindTo(Book::name)
}