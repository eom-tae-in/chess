package dto;

import java.util.List;

public class MoveStateRequest {

    private static final int SOURCE_POSITION_INDEX = 1;
    private static final int TARGET_POSITION_INDEX = 2;
    private static final String BLANK = " ";

    private final String sourcePosition;
    private final String targetPosition;

    private MoveStateRequest(final String sourcePosition, final String targetPosition) {
        this.sourcePosition = sourcePosition;
        this.targetPosition = targetPosition;
    }

    public String getSourcePosition() {
        return sourcePosition;
    }

    public String getTargetPosition() {
        return targetPosition;
    }

    public static MoveStateRequest from(String moveInfo) {
        List<String> moveSegments = List.of(moveInfo.split(BLANK));
        return new MoveStateRequest(moveSegments.get(SOURCE_POSITION_INDEX) , moveSegments.get(TARGET_POSITION_INDEX));
    }
}
