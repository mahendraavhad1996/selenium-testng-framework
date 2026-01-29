# Selenium TestNG Framework (Maven)

Minimal Page Object Model framework using Selenium, TestNG, WebDriverManager and Apache POI for Excel-driven tests.

Run tests:

```bash
mvn test
```

System properties:
- `-Dbrowser=chrome` (default)
- `-Dheadless=true` (run Chrome headless)

Project structure:
- `src/main/java/com/framework/basetest` - `BaseTest`
- `src/main/java/com/framework/pages` - Page objects
- `src/main/java/com/framework/utils` - Excel and config utilities
- `src/test/java/com/framework/tests` - TestNG tests using DataProvider

Selenium TestNG Automation Framework

Features:
- Data driven testing using Excel
- TestNG framework
- WebDriverManager
- GitHub Actions CI