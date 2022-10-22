package ladder.view;

import ladder.model.Ladder;
import ladder.model.LadderLine;
import ladder.model.Players;
import ladder.model.Point;

import java.util.List;

public class OutputView {

    private OutputView() {
        throw new AssertionError();
    }

    public static void show(String message) {
        System.out.println(message);
    }

    public static void nextLine() {
        System.out.println();
    }

    private static void nextTab(String message) {
        System.out.printf("%7s", message);
    }

    public static void showResultMessage() {
        show("실행결과");
    }

    public static void showPlayersName(Players players) {
        players.getPlayers()
                .forEach(player -> nextTab(player.getName()));

        nextLine();
    }

    public static void showLadder(Ladder ladder) {
        ladder.getLadderLine().stream().forEach(ladderLine -> {
            showLadderLine(ladderLine);
            nextLine();
        });
    }

    private static void showLadderLine(LadderLine ladderLine) {
        nextTab("|");

        List<Point> points = ladderLine.getPointList();

        for (int i = 0; i < ladderLine.getPointList().size() - 1; i++) {
            if (points.get(i).getDirection().isConnected()) {
                showLadderLine();
            } else {
                nextTab("|");
            }
        }
    }

    private static void showLadderLine() {
        System.out.printf("%s%s", "------", "|");
    }
}