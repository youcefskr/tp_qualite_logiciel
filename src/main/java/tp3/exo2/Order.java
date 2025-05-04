package tp3.exo2;

import java.util.Objects;

public class Order {
    private long id;
    private String details;

    public Order(long id, String details) {
        this.id = id;
        this.details = details;
    }

    public long getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && details.equals(order.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, details);
    }
}
