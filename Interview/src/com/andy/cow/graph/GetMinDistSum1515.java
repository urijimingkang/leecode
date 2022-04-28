package com.andy.cow.graph;

class GetMinDistSum1515 {
    private int maxIteration = 10000;
    private double learningRate = 0.03;

    public double getMinDistSum(int[][] positions) {
        if(positions.length == 1) return 0.0;
        double x = 0.5, y = 0.5;
        double eps = 1e-8;
        double loss = getLoss(x, y, positions);
        for (int i = 0; i < maxIteration; i++) {
            double[] gradient = getGradient(x, y, positions);
            double newX = x - gradient[0] * learningRate;
            double newY = y - gradient[1] * learningRate;
            double newLoss = getLoss(newX, newY, positions);
            if (loss < newLoss) {
                learningRate /= 3;
            } else if (loss - newLoss < eps) {
                return newLoss;
            } else {
                loss = newLoss;
                x = newX;
                y = newY;
            }
        }
        return loss;
    }

    private double[] getGradient(double x, double y, int[][] positions) {
        double[] gradient = new double[]{0.0, 0.0};
        for (int[] position : positions) {
            double div = Math.sqrt(Math.pow(x - position[0], 2) + Math.pow(y - position[1], 2));
            gradient[0] += (x - (double) position[0]) / div;
            gradient[1] += (y - (double) position[1]) / div;
        }
        return gradient;
    }

    private double getLoss(double x, double y, int[][] positions) {
        double loss = 0.0;
        for (int[] position : positions) {
            loss += Math.sqrt(Math.pow(x - position[0], 2) + Math.pow(y - position[1], 2));
        }
        return loss;
    }
}

//作者：leodaddy
//链接：https://leetcode-cn.com/problems/best-position-for-a-service-centre/solution/ti-du-xia-jiang-java-by-junyi-hu/
