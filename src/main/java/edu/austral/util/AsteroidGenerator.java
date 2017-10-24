package edu.austral.util;

import edu.austral.model.Asteroid;
import edu.austral.model.Board;
import processing.core.PApplet;

/**
 * Created by AlumnosFI on 24/10/2017.
 */
public interface AsteroidGenerator{
    Asteroid generateAsteroid(Board board, PApplet graphics);
}
