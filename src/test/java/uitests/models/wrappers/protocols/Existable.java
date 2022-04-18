package uitests.models.wrappers.protocols;

public interface Existable<T> {
    T shouldBeExist(Integer timeDuration);
    T shouldBeExist();
    T shouldNotBeExist(Integer timeDuration);
    T shouldNotBeExist();
}