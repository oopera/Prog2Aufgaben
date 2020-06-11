package de.hrw.progra2.assignment4;

public abstract class AbstractBeing extends AbstractGameElement {
    private long maxEnergy;
    private long currentEnergy;

    public AbstractBeing(String name, Vector3D position, long maxEnergy, long currentEnergy) {
        super(name, position);
        this.maxEnergy = maxEnergy;
        this.currentEnergy = currentEnergy;
    }

    public long getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(long maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public long getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(long currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    boolean isLiving() {
        if (currentEnergy > 0) {
        }
        return true;
    }

    public long revive() {
        currentEnergy = maxEnergy;
        return maxEnergy;
    }

    public long addEnergy(long energy) {
        currentEnergy += energy;
        if (currentEnergy > maxEnergy)
            currentEnergy = maxEnergy;
        return currentEnergy;
    }

    public long deductEnergy(long energy) {
        currentEnergy -= energy;
        if (currentEnergy < 0)
            currentEnergy = 0;
        return currentEnergy;
    }



}


