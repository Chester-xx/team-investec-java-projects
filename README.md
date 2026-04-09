# PRO731 - Java Industry Prep

## Team Investec

### Contributors:
- **Maximus Bergmann** [Team Lead]
- **Tahir Sallie** - [Role/Specialty]
- **Matthew Magadza** - [Role/Specialty]
- **Rameez Cassim** - [Role/Specialty]
- **Hamza Mohammad** - [Role/Specialty]
- **Jaden Ruiters** - [Role/Specialty]
- **Jared Borman** - [Role/Speciality]

#### Overseer - Muaaz 

## Repository Structure

```
team-investec-java-projects/
│
├── src/                                             # Projects source code
│   │
│   ├── banking/                              # Banking system project
│   │   ├── model/
│   │   │   ├── BankAccount.java                     # Abstract base class
│   │   │   ├── SavingsAccount.java                  # Extends BankAccount
│   │   │   ├── CurrentAccount.java                  # Extends BankAccount
│   │   │   ├── Transaction.java                     # Immutable record of one event
│   │   │   └── InsufficientFundsException.java
│   │   ├── auth/
│   │   │   ├── User.java                            # Base user with role
│   │   │   ├── Customer.java                        # Subclass (optional)
│   │   │   └── Teller.java                          # Subclass with extra permissions
│   │   ├── service/
│   │   │   └── BankService.java                     # Business logic, holds all accounts
│   │   └── Main.java                                # Entry point, menu loop
│   │
│   ├── data-pipeline/                               # Data pipeline project
│   │
│   └── rest-api/                                    # REST API project
│
├── docs/                                            # Documentation
│      ├── Sprint_Briefs_and_Tickets.docx            # Project context, architecture, dependencies and tickets for all 3 sprints
│      └── Agile_Simulation_Team_Charter.docx        # Team dynamic, role and professional behavior
│
├── resources/                                       # Resources, references and links
│
├── README.md                                        # Descriptor
├── LICENSE                                          # MIT source code license
└── .gitignore                                       # Git ignore configuration
```

## Help

### Prerequisites:
- **Java Development Kit (JDK)**: Version `23` or higher
- **Build Tool**: Not specified
- **IDE**: VS Code or NetBeans
- **Git**: Version control system

### Instructions

1. **Clone repository**
   ```bash
   cd C://path/to/team-investec-java-projects
   git clone https://github.com/Chester-xx/team-investec-java-projects.git
   ```

2. **Verify Java installation**
    ```bash
    java --version
    ```

3. **Build the project**
    ```bash
    # Using VS Code Java Extension by `Microsoft`
    Key Bind: F5

    # Maven
    mvn clean install
   
    # Gradle
    gradle build
    ```

4. **Tests | Not Specified | Relative to build tools**
    ```bash
    # Maven
    mvn test
   
    # Gradle
    gradle test
    ```

## Project Milestones

- **Banking System**: 
- **Data Pipeline**: 
- **REST API**: 

---

## Contribution Guidelines

### Outline
```bash
# Format:
type: short description of what changed — closes #ticket_number

# Types:
feat:     a new feature or piece of functionality
fix:      a bug fix
refactor: restructuring code without changing what it does
docs:     adding or updating a README or comment
test:     adding tests (stretch goal)

# Examples:
feat: add SavingsAccount minimum balance enforcement — closes #4
fix: withdraw() was not logging the transaction — closes #7
refactor: extract validateAmount() into separate method — closes #9
docs: update README with how to run the banking app — closes #12
```

1. **Branching Strategy**
   - Create feature branches for new topics: `feature/topic-name`
   - Create fix branches for corrections: `fix/issue-name`

2. **Commit Messages**
   - Format: `[Category] [Outline] - closes [ticket number]`
   - Commit description will go more in depth 

3. **Code Quality**
   - Top level comments, camelCase, doxygen formatting
   - Corrective implementations for possible outcomes
   - Tests on inputs and expected outputs

4. **Pull Requests**
   - Include a description of changes
   - Reference any related issues
   - Request review from at least one team member
   - Merge only after approval

## Communication & Support

- **Project Meetings**: [Thursday Weekly]
- **Communication**: WhatsApp Group + Campus
- **Issue Tracking**: GitHub Issues for bug reports and feature requests
- **Documentation**: Implement `/docs` folder for detailed guides

## License

![MIT](https://github.com/Chester-xx/team-investec-java-projects/blob/main/LICENSE)
