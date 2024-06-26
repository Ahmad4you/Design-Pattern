package observer;

/**
 * The Subject (Observable) Interface
 * @author Ahmad Alrefai
 * 
 */
public interface Subject {

    /**
     * Add Observer Method
     * @param observer observer
     */
    void addObserver(Observer observer);

    /**
     * Remove an observer method
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * Notify all observers of this subject
     */
    void notifyAllObservers();
}
