package com.cs26l.focuslist;

import javafx.animation.Interpolator;
import javafx.fxml.FXML;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.animation.FillTransition;
import javafx.animation.*;
import javafx.scene.Node;
import javafx.util.Duration;

public class TransitionManager {

    void translate(Node node, double fromX, double toX, double fromY, double toY, double duration, String easingType) {
        CustomInterpolator customInterpolator = new CustomInterpolator();
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(node);
        translate.setFromX(fromX);
        translate.setToX(toX);
        translate.setFromY(fromY);
        translate.setToY(toY);
        translate.setDuration(Duration.millis(duration));
        translate.setInterpolator(new CustomEasingInterpolator(customInterpolator, easingType));
        translate.play();
    }

    void fade(Node node, double from, double to, double duration) {
        FadeTransition fade = new FadeTransition();
        fade.setNode(node);
        fade.setFromValue(from);
        fade.setToValue(to);
        fade.setDuration(Duration.millis(duration));
        fade.play();
    }
}

class AnimationManager {
    void floating(Node node, double fromX, double toX, double fromY, double toY, double duration, String easingType) {
        CustomInterpolator customInterpolator = new CustomInterpolator();
        TranslateTransition floating = new TranslateTransition();
        floating.setNode(node);
        floating.setFromX(fromX);
        floating.setToX(toX);
        floating.setFromY(fromY);
        floating.setToY(toY);
        floating.setDuration(Duration.millis(duration));
        floating.setAutoReverse(true);
        floating.setCycleCount(-1);
        floating.setInterpolator(new CustomEasingInterpolator(customInterpolator, easingType));
        floating.play();
    }
}

// Custom interpolator class to handle different easing types
class CustomEasingInterpolator extends Interpolator {
    private final CustomInterpolator customInterpolator;
    private final String easingType;

    public CustomEasingInterpolator(CustomInterpolator customInterpolator, String easingType) {
        this.customInterpolator = customInterpolator;
        this.easingType = easingType;
    }

    @Override
    protected double curve(double t) {
        switch (easingType) {
            case "linear":
                return customInterpolator.linear(t);
            case "easeIn":
                return customInterpolator.easeIn(t);
            case "easeOut":
                return customInterpolator.easeOut(t);
            case "easeInFromOut":
                return customInterpolator.easeInFromOut(t);
            case "easeInCubic":
                return customInterpolator.easeInCubic(t);
            case "easeOutCubic":
                return customInterpolator.easeOutCubic(t);
            case "easeInCubicFromOut":
                return customInterpolator.easeInFromOutCubic(t);
            case "elasticEaseIn":
                return customInterpolator.elasticEaseIn(t);
            case "elasticEaseOut":
                return customInterpolator.elasticEaseOut(t);
            case "bounceEaseIn":
                return customInterpolator.bounceEaseIn(t);
            case "bounceEaseOut":
                return customInterpolator.bounceEaseOut(t);
            default:
                return t;
        }
    }
}

class CustomInterpolator {
    public double linear(double t) {
        return t;
    }

    public double easeIn(double t) {
        return t * t;
    }

    public double easeOut(double t) {
        return t * (2 - t);
    }

    public double easeInFromOut(double t) {
        return easeIn(1 - t);
    }

    public double easeInCubic(double t) {
        return t * t * t;
    }

    public double easeOutCubic(double t) {
        return --t * t * t + 1;
    }

    public double easeInFromOutCubic(double t) {
        return easeInCubic(1 - t);
    }

    public double elasticEaseIn(double t) {
        return 1 - elasticEaseOut(1 - t);
    }

    public double elasticEaseOut(double t) {
        if (t == 1) return 1;
        double p = 0.3;
        return Math.pow(2, -10 * t) * Math.sin((t - p / 4) * (2 * Math.PI) / p) + 1;
    }

    public double bounceEaseIn(double t) {
        return 1 - bounceEaseOut(1 - t);
    }

    public double bounceEaseOut(double t) {
        if (t < (1 / 2.75)) {
            return (7.5625 * t * t);
        } else if (t < (2 / 2.75)) {
            t -= (1.5 / 2.75);
            return (7.5625 * t * t + .75);
        } else if (t < (2.5 / 2.75)) {
            t -= (2.25 / 2.75);
            return (7.5625 * t * t + .9375);
        } else {
            t -= (2.625 / 2.75);
            return (7.5625 * t * t + .984375);
        }
    }
}