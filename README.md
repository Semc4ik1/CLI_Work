# *Тестовое задание ШИФТ ЦФТ (Java) 08/24*
[Ссылка на файл с заданием](https://drive.google.com/file/d/10qhGjn7biURykP8hIcT6NJHoGX-WOHUh/view)

---

## Инструкция по запуску

Проект разработан с использованием Java 17 и системы сборки Gradle 8.3.
Использованные зависимости (см. *build.gradle*):
- Apache Commons CLI (1.8.0)
- ProjectLombok (1.18.34)

Соберите проект в исполняемый Jar:

    ./gradlew jar

Исполняемый Jar расположен в директории build/libs.
Параметры запуска:
- `-i` - список входных файлов (не менее 1) (*обязательный*)
- `-o` - путь к выходным файлам (*необязательный*)
- `-p` - префикс для выходных файлов (*необязательный*)
- `-a` - режим добавления в существующие файлы (*необязательный*)
- [`-f`/`-s`] - вид статистики (полная/краткая) (*необязательный*, по умолчанию - краткая)

Примеры запуска:

    java -jar filter-1.0-SNAPSHOT.jar -i in1.txt in2.txt -o /some/path -p res_ -a -f
    java -jar filter-1.0-SNAPSHOT.jar -i a.txt b.txt c.txt

**TODO:**
- Логирование
- Юнит тесты