package multicampus.f2_lamda.function;

@FunctionalInterface
public interface Consumer<T> {
	void accept(T t);
}
