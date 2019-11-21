package com.wildcoding.web.application;

import com.wildcoding.business.domain.RoomReservation;
import com.wildcoding.business.service.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {
    @MockBean
    private ReservationService reservationService;
    @Autowired
    private MockMvc mockMvc;
    private static final SimpleDateFormat DATE_FORMAT=new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void getReservationsTest() throws Exception {
        Date date=DATE_FORMAT.parse("2017-01-01");
        List<RoomReservation>mockReservationList=new ArrayList<>();
        RoomReservation mockRoomReservation = new RoomReservation();
        mockRoomReservation.setDate(date);
        mockRoomReservation.setGuestId(1);
        mockRoomReservation.setFirstName("FIRSTNAME");
        mockRoomReservation.setLastName("LASTNAME");
        mockRoomReservation.setRoomNumber("JI");
        mockRoomReservation.setRoomId(100);
        mockRoomReservation.setRoomName("ROOMNAME");
        mockReservationList.add(mockRoomReservation);

        given(reservationService.getRoomReservationsForDate(date)).willReturn(mockReservationList);
        this.mockMvc.perform(get("/reservations?date=2017-01-01"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("LASTNAME, FIRSTNAME")));

    }
}
