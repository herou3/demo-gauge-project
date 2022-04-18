package uitests.models.wrappers.protocols;

public interface Displayable<T> {
    T shouldBeVisible();
    T shouldBeVisible(Integer timeDuration);
    T shouldNotBeVisible();
}