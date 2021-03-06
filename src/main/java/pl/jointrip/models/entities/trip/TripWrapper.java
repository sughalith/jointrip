package pl.jointrip.models.entities.trip;

import lombok.Getter;
import lombok.Setter;
import pl.jointrip.models.entities.documents.Documentstore;
import pl.jointrip.models.entities.documents.ImagesStore;
import pl.jointrip.models.entities.user.User;

import java.util.List;
import java.util.Map;

@Setter
@Getter
public class TripWrapper {

    private Trip trip;
    private Map<String, Integer> statistics;
    private List<DailyTripPlan> dailyTripPlanList;
    private List<Documentstore> documentstoreList;
    private List<ImagesStore> imagesStoreList;
    private ImagesStore mainImageStore;
    private User user;

    public TripWrapper(Trip trip) {
        this.trip = trip;
    }

    public TripWrapper(Trip trip, Map<String, Integer> statistics) {
        this.trip = trip;
        this.statistics = statistics;
    }

    public TripWrapper(Trip trip, Map<String, Integer> statistics, ImagesStore mainImageStore) {
        this.trip = trip;
        this.statistics = statistics;
        this.mainImageStore = mainImageStore;
    }

    public TripWrapper(Trip trip, List<DailyTripPlan> dailyTripPlanList, List<Documentstore> documentstoreList) {
        this.trip = trip;
        this.dailyTripPlanList = dailyTripPlanList;
        this.documentstoreList = documentstoreList;
    }


    public TripWrapper(Trip trip, List<DailyTripPlan> dailyTripPlanList, List<Documentstore> documentstoreList, ImagesStore mainImageStore, User user) {
        this.trip = trip;
        this.dailyTripPlanList = dailyTripPlanList;
        this.documentstoreList = documentstoreList;
        this.mainImageStore = mainImageStore;
        this.user = user;
    }
}
