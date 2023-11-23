class TrapezoidGridLayoutStrategy : GridLayoutStrategy() {

    override fun fetchGridCoordinates(builder: HexagonalGridBuilder<out SatelliteData>): Iterable<CubeCoordinate> {
        val coords = ArrayList<CubeCoordinate>(builder.getGridHeight() * builder.getGridWidth())
        for (gridZ in 0 until builder.getGridHeight()) {
            for (gridX in 0 until builder.getGridWidth()) {
                coords.add(CubeCoordinate.fromCoordinates(gridX, gridZ))
            }
        }
        return coords
    }

    override fun checkParameters(gridHeight: Int, gridWidth: Int): Boolean {
        return checkCommonCase(gridHeight, gridWidth)
    }

    override fun getName(): String {
        return "TRAPEZOID"
    }
}
