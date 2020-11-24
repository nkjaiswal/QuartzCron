package DatabaseIdentifierUtils;

public class DatabaseIdentifierStore {
    private final static DatabaseIdentifierStore storage = new DatabaseIdentifierStore();
    private DatabaseIdentifierStore() {

    }
    public static DatabaseIdentifierStore getInstance() {
        return storage;
    }


    private DatabaseIdentifiers dbIdentifier;
    public DatabaseIdentifiers getDbIdentifier() {
        return dbIdentifier;
    }
    public void setDbIdentifier(DatabaseIdentifiers dbIdentifier) {
        this.dbIdentifier = dbIdentifier;
    }

}
