package devices.iterator;

import devices.impl.SmartDevice;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

// Tydzien 4, Wzorzec Iterator 1
public class FilteringSmartDeviceIterator implements Iterator<SmartDevice> {
    private final Iterator<SmartDevice> iterator;
    private final Predicate<SmartDevice> predicate;
    private SmartDevice nextItem;

    public FilteringSmartDeviceIterator(Iterator<SmartDevice> iterator, Predicate<SmartDevice> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
        advance();
    }

    private void advance() {
        nextItem = null;
        while (iterator.hasNext()) {
            SmartDevice candidate = iterator.next();
            if (predicate.test(candidate)) {
                nextItem = candidate;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return nextItem != null;
    }

    @Override
    public SmartDevice next() {
        if (nextItem == null) {
            throw new NoSuchElementException();
        }
        SmartDevice current = nextItem;
        advance();
        return current;
    }

    @Override
    public void remove() {
        iterator.remove();
    }
}
// Koniec Tydzien 4, Wzorzec Iterator 1
