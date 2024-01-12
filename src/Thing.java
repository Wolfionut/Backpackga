public class Thing {
    float value;
    float weight;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Thing(float value, float weight) {
        this.value = value;
        this.weight = weight;
    }
}
