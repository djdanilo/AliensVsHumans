package App;

class Compass {

    private String currentDirection;


    public Compass() {
        this.currentDirection = "NORTH";
    }


    public String getDirection() {
        return this.currentDirection;
    }

    private void setDirection(String direction) {
        this.currentDirection = direction;
    }


    public void changeDirection(String relativeDirection) {

        switch (this.getDirection())
        {
            case "NORTH" :
                switch (relativeDirection){
                    case "left":
                        this.setDirection("WEST");
                        break;

                    case "right":
                        this.setDirection("EAST");
                        break;

                    case "aboutFace":
                        this.setDirection("SOUTH");
                        break;
                }
                break;

            case "SOUTH" :
                switch (relativeDirection) {
                    case "left":
                        this.setDirection("EAST");
                        break;

                    case "right":
                        this.setDirection("WEST");
                        break;

                    case "aboutFace":
                        this.setDirection("NORTH");
                        break;
                }
                break;

            case "EAST":
                switch (relativeDirection) {
                    case "left":
                        this.setDirection("NORTH");
                        break;

                    case "right":
                        this.setDirection("SOUTH");
                        break;

                    case "aboutFace":
                        this.setDirection("WEST");
                        break;
                }
                break;

            case "WEST":
                switch (relativeDirection) {
                    case "left":
                        this.setDirection("SOUTH");
                        break;

                    case "right":
                        this.setDirection("NORTH");
                        break;

                    case "aboutFace":
                        this.setDirection("EAST");
                        break;
                }
                break;
        }

    }
}
