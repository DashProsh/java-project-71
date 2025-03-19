plugins {
    id("base") // Минимальный плагин для корневого проекта
}

subprojects {
    apply(plugin = "checkstyle")

    tasks.withType<Checkstyle>().configureEach {
        reports {
            xml.required.set(true) // Включает XML-отчет
            html.required.set(false) // Отключает HTML-отчет
        }
    }
}
