package Repositories.Specifications;

public interface SqlSpecification extends Specification {
    String toSqlQuery();
}
