plugins {
    id("java")
    application
}

group = "net.uniquepixels"
version = "1.0-SNAPSHOT"

val mainClassPath = "$group.discord.general.DiscordBot"

repositories {
    mavenCentral()
}

application {
    mainClass = mainClassPath
}

repositories {
    mavenCentral()
}

dependencies {

    // Java Discord Application
    implementation("net.dv8tion:JDA:5.0.0-beta.20") // https://github.com/discord-jda/JDA?tab=readme-ov-file#documentation

    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.10.1")


    // OkHttp Client
    implementation("com.squareup.okhttp3:okhttp:4.12.0") // https://square.github.io/okhttp/
}

tasks {

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    withType<JavaCompile> {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }

    withType<Javadoc> {
        options.encoding = Charsets.UTF_8.name()
    }

    withType<ProcessResources> {
        filteringCharset = Charsets.UTF_8.name()
    }
}