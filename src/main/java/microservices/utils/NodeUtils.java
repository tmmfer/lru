package microservices.utils;

import microservices.model.Node;

import java.util.Random;

public class NodeUtils {
    public static boolean isEqual(Node node, Object o) {
        return new Random().nextBoolean();
    }

    public static int generateHashCode(Node node) {
        return new Random().nextInt();
    }
}
