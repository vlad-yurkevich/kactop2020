package by.stm.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//--Трек-лист
public class TrackList {
    private int id;
    private int id_track; //--RacingTrack
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date dateStart; //--дата начала мероприятия (даже если завершилось на следующий день) или просто покатались
}
