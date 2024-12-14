package de.hegmanns.training.aoc2022.day21;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;
import java.util.Optional;

public class Monkey implements PropertyChangeListener{

    PropertyChangeSupport valueSetSupport;

    private String name;
    private Long value;

    private MonkeyExpression monkeyExpression;

    public void signalForSetValue(PropertyChangeListener listener) {
        this.valueSetSupport.addPropertyChangeListener(listener);
    }

    public static Monkey createConstantMonkey(long value) {
        return new Monkey("" + value, value);
    }

    public Monkey(String name, Long value) {
        this.name = name;
        this.value = value;

        this.valueSetSupport = new PropertyChangeSupport(this);
    }

    public Monkey(String name) {
        this(name, null);
    }

    public String getName() {
        return name;
    }

    public Optional<Long> getValue() {
        return Optional.ofNullable(value);
    }

    public void setValue(long value) {
        if (this.value != null) {
            throw new IllegalArgumentException("value for this instance '" + getName() + "' already exists with value '" + this.value + "'");
        }
        this.value = value;
        this.valueSetSupport.firePropertyChange("value", null, this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monkey monkey = (Monkey) o;
        return name.equals(monkey.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Monkey{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Monkey monkey = (Monkey) evt.getSource();

        resolveMonkeys(monkey);
    }

    private void resolveMonkeys(Monkey monkey) {
        if (this.value != null) {
            return;
        }
        if (this.monkeyExpression.getUnresolvedMonkeys().isEmpty()) {
            this.monkeyExpression.resolve();
        }
    }

    public MonkeyExpression getMonkeyExpression() {
        return this.monkeyExpression;
    }

    public void setMonkeyExpression(MonkeyExpression monkeyExpression) {
        this.monkeyExpression = monkeyExpression;
    }
}
