class RectangularGridLayoutStrategy : GridLayoutStrategy() {

    override fun fetchGridCoordinates(builder: HexagonalGridBuilder<out SatelliteData>): Iterable<CubeCoordinate> {
        val coords = ArrayList<CubeCoordinate>( builder.getGridHeight() * builder.getGridWidth())
        for (y in 0 until builder.getGridHeight()) {
            for (x in 0 until builder.getGridWidth()) {
                if(y==0 && x%2==1) {
                    continue
                }
                else {
                    val gridX = CoordinateConverter.convertOffsetCoordinatesToCubeX(x, y, builder.getOrientation())
                    val gridZ = CoordinateConverter.convertOffsetCoordinatesToCubeZ(x, y, builder.getOrientation())
                    coords.add(CubeCoordinate.fromCoordinates(gridX, gridZ))
                }
            }
        }
        return coords
    }

    override fun checkParameters(gridHeight: Int, gridWidth: Int): Boolean {
        return checkCommonCase(gridHeight, gridWidth)
    }

    override fun getName(): String {
        return "RECTANGULAR"
    }
}
