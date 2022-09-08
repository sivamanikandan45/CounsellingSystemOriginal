package com.model;

public class Admin {
    private boolean randomNoAssigned;
    private boolean rankGenerated=false;
    private boolean seatAllotted=false;
    private boolean cutoffAssigned=false;

    public boolean isRankGenerated() {
        return rankGenerated;
    }

    public boolean isSeatAllotted() {
        return seatAllotted;
    }

    public boolean isCutoffAssigned() {
        return cutoffAssigned;
    }

    public boolean isRandomNoAssigned() {
        return randomNoAssigned;
    }

    public void setRandomNoAssigned(boolean randomNoAssigned) {
        this.randomNoAssigned = randomNoAssigned;
    }

    public void setCutoffAssigned(boolean cutoffAssigned) {
        this.cutoffAssigned = cutoffAssigned;
    }

    public void setRankGenerated(boolean rankGenerated) {
        this.rankGenerated = rankGenerated;
    }

    public void setSeatAllotted(boolean seatAllotted) {
        this.seatAllotted = seatAllotted;
    }
}
