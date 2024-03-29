/*
 * @fileoverview    {JavaGenericImageFactory}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementation done.
 * @version 2.0     Documentation added.
 */
package com.project.dev.joystick.desktop;

import com.project.dev.joystick.factory.GenericImageAbstractFactory;
import com.project.dev.joystick.graphic.GenericImage;

/**
 * TODO: Description of {@code JavaGenericImageFactory}.
 *
 * @author Dyson Parra
 * @since 11
 */
public class JavaGenericImageFactory extends GenericImageAbstractFactory {

    /**
     * FIXME: Description of {@code JavaGenericImageFactory}.
     *
     */
    public JavaGenericImageFactory() {
        super();
    }

    /**
     * FIXME: Description of {@code makeGenericImage}. Fabrica una imagen genérica con solo la ruta.
     *
     * @param path es la ruta de la imagen.
     * @return una imagen genérica.
     * @throws java.lang.Exception
     */
    @Override
    public GenericImage makeGenericImage(String path) throws Exception {
        return new JavaGenericImage(path);
    }
}
