# Ktor Project with PostgreSQL and H2

## 📌 Overview
This project is a backend application built using [Ktor](https://ktor.io/), a framework for building asynchronous servers and clients in Kotlin. It utilizes PostgreSQL and H2 as databases and follows best practices for dependency management and structured configuration.

## 📂 Project Structure
```plaintext
project-root/
│── src/
│   ├── main/
│   │   ├── kotlin/com/geovannycode/
│   │   │   ├── Application.kt
│   │   │   ├── modules/
│   │   │   ├── routes/
│   ├── test/
│── build.gradle.kts
│── settings.gradle.kts
│── README.md
```

## 🚀 Technologies Used
- **Kotlin** (`1.8.10`)
- **Ktor** (`2.2.4`)
- **PostgreSQL Driver** (`42.5.1`)
- **H2 Database** (`2.1.214`)
- **Logback** (`1.2.11`)
- **Ktorm ORM** (`3.4.1`)

## ⚙️ Configuration
The project dependencies are managed using Gradle with the following versions specified:
```kotlin
val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val postgres_version: String by project
val h2_version: String by project
```

## 🔌 Plugins
The following plugins are used:
```kotlin
plugins {
    kotlin("jvm") version "1.8.10"
    id("io.ktor.plugin") version "2.2.4"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.10"
}
```

## 📦 Dependencies
```kotlin
dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
    implementation("org.ktorm:ktorm-core:3.4.1")
    implementation("org.ktorm:ktorm-support-postgresql:3.4.1")
    implementation("org.postgresql:postgresql:$postgres_version")
    implementation("com.h2database:h2:$h2_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
```

## ▶️ Running the Application
To run the project, execute:
```sh
./gradlew run
```
This will start the Ktor server with Netty as the application engine.

## 🛠️ Environment Configuration
The application checks for a development environment flag:
```kotlin
val isDevelopment: Boolean = project.ext.has("development")
applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
```

## 🗄️ Database Setup
- **PostgreSQL:** The application is configured to connect to a PostgreSQL database. Ensure that a PostgreSQL instance is running and properly configured in your environment.
- **H2 Database:** An in-memory H2 database is included for testing and development purposes.

## 🧪 Testing
Run tests using:
```sh
./gradlew test
```
This will execute the unit tests configured in the project.

## 📜 License
This project is open-source and distributed under the MIT License.



