package cc.onion.cosyfans.base.interfaces;

/**
 *  @author guobihai
 * @Created 3/15/19
 * @Editor zrh
 * @Edited 3/15/19
 * @Type
 * @Layout
 * @Api
 */
public interface ImageClickListener {

    void onImageClick(String url);

    default void onDeleteClick(String url) {
    }

    default void onAddClick() {

    }


}
