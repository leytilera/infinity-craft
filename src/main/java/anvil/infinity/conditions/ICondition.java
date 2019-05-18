package anvil.infinity.conditions;

public interface ICondition<T> {

    boolean isFulfilled(T information);

}
