package com.iulian.iancu.spacetracker.data

import com.iulian.iancu.spacetracker.SpaceTrackerService

class SpaceRepository constructor(private val retrofitService: SpaceTrackerService) {
    suspend fun getUpdates() =
        retrofitService.getLatestLaunches()
}