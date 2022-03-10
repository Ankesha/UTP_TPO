/**
 * @Author: Patryk Kamiński
 */

package assignment01;

public interface IDeeplyCloneable<TElement extends IDeeplyCloneable<TElement>> {

	TElement deepClone();
}