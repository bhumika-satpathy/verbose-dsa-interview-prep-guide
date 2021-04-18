package Greedy;

public class Can_Place_Flowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int availableZeros = 0;

        if(flowerbed.length == 1)
            return (flowerbed[0] == 0 && n == 1) || (flowerbed[0] == 1 && n == 0) || (flowerbed[0] == 0 && n == 0);

        if(flowerbed[0] == 0 && flowerbed[1] == 0){
            availableZeros++;
            flowerbed[0] = 1;
        }

        for(int i = 1; i < flowerbed.length - 1; ){
            if(flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0){
                flowerbed[i] = 1;
                i++;
                availableZeros++;
            }
            i++;
        }

        if(flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0 && flowerbed.length != 2)
            availableZeros++;

        return availableZeros >= n;
    }
}
