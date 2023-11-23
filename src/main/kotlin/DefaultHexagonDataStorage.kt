import com.sun.istack.internal.Nullable

class DefaultHexagonDataStorage<SatelliteData> : HexagonDataStorage<SatelliteData> {

    private val storage = LinkedHashMap<CubeCoordinate, SatelliteData>()

    override val coordinates: Iterable<CubeCoordinate>
        get() = storage.keys

    override fun addCoordinate(cubeCoordinate: CubeCoordinate) {
        storage[cubeCoordinate] = null!!
    }

   override fun addCoordinate(cubeCoordinate: CubeCoordinate, satelliteData: SatelliteData): Boolean {
        val previous = storage.put(cubeCoordinate, satelliteData)
        return previous != null
    }

    override fun getSatelliteDataBy(cubeCoordinate: CubeCoordinate): SatelliteData {
//        return if (storage.containsKey(cubeCoordinate)) storage[cubeCoordinate]!!
        return storage[cubeCoordinate]!!
    }

    override fun containsCoordinate(cubeCoordinate: CubeCoordinate): Boolean {
        return storage.containsKey(cubeCoordinate)
    }

    override fun hasDataFor(cubeCoordinate: CubeCoordinate): Boolean {
        return storage.containsKey(cubeCoordinate) && storage[cubeCoordinate] != null
    }

    override fun clearDataFor(cubeCoordinate: CubeCoordinate): Boolean {
        var result = false
        if (hasDataFor(cubeCoordinate)) {
            result = true
        }
        storage[cubeCoordinate] = null!!
        return result
    }
}
