package shtait.generators;

import shtait.drawableitems.Drawable;

import java.io.IOException;

public interface Generator {
    Drawable generate() throws IOException;

}
