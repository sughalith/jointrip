package pl.jointrip.services.tripService;

import pl.jointrip.models.entities.comments.Comments;
import pl.jointrip.models.entities.comments.CommentsWrapper;
import pl.jointrip.models.entities.trip.*;
import pl.jointrip.models.entities.user.User;
import pl.jointrip.models.system.SystemNotification;
import pl.jointrip.models.viewModels.tripSearch.TripSearchVM;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface TripService {

    boolean saveTrip(Trip trip);

    public boolean editTrip(Trip trip);

    boolean joinToTripByUser(int id);

    boolean saveCommentByUser(Comments comment, int tripId);

    TripMember addNewMember(Trip trip);

    TripsMemberWrapper tripsMemberWrapper(int tripId);

    TripMember tripMemberStatusUpdate(TripMember tripMember);

    CommentsWrapper commentsWrapper(int tripId);

    Comments commentUpdateByOwner(Comments comments);

    Map<String, List<TripWrapper>> tripMapWithStatisticForOrganisator();

    List<TripWrapper> tripWithStatisticsForOrganisator(int tripStatus);

    List<TripWrapper> tripsWithStatisicForNoMemberUsers();

    TripWrapper createTripWrapperForNewUsers(Trip trip);

    Map<String, Integer> amountOfTripsForUser();

    Map<String, List<TripWrapper>> allLoggedUserTrips();

    int daysAmountInTrip(Trip trip) throws ParseException;

    ChatTrip chatTripAddMessage(Trip trip, User tripMember, String message, int messageKind);

    void commentsListUpdateByOwner(List<Comments> commentsList);

    void tripMemberListUpdate(List<TripMember> tripMemberList);

    boolean addedTripNotification(Trip trip);

    SystemNotification addedCommentNotification(Comments comment, int tripId);

    abstract SystemNotification joinedTripNotification(int id);

    List<TripWrapper> findAllActiveTripsForNoLogUser();

    List<TripWrapper> joinedTripsByUserByTripMemberStatus(int tripMemberStatus);

    List<Trip> findTripByTripMembersNot();

    List<Trip> findTripByUserByUserId();

    List<TripWrapper> tripWithStatisticsForOrganisator();

    TripWrapper createTripWrapperForOrganisator(Trip trip);

    List<TripWrapper> findLatestTripsWrapper();

    Trip findById(int id);

    boolean existsTripByTripMembers(Trip trip, User user);

    List<Comments> findByTripAndStatusIs(Trip trip, int status);

    boolean removeTrip(int id);

    List<TripWrapper> searchTrips(TripSearchVM tripSearch, boolean logged);
}
