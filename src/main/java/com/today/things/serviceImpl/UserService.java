package com.today.things.serviceImpl;

import com.today.things.dto.ActivityActionLogDTO;
import com.today.things.dto.ActivityAnswerDTO;
import com.today.things.dto.UserDTO;
import com.today.things.model.ActivityActionLog;
import com.today.things.model.ActivityAnswer;
import com.today.things.model.Role;
import com.today.things.model.TodayUser;
import com.today.things.repo.ActivityActionLogRepository;
import com.today.things.repo.ActivityAnswerRepository;
import com.today.things.repo.RoleRepository;
import com.today.things.repo.TodayUserRepository;
import com.today.things.serviceI.UserServiceI;
import com.today.things.util.Constants;
import com.today.things.util.TodayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class UserService implements UserServiceI, UserDetailsService {

    @Autowired
    TodayUserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ActivityAnswerRepository activityAnswerRepository;

    @Autowired
    ActivityActionLogRepository activityActionLogRepository;

    private MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public TodayResponse register(UserDTO userDTO) {

        if (userDTO != null) {
            TodayUser todayUser = new TodayUser();

            if (userDTO.getLocation() != null) {
                todayUser.setLocation(userDTO.getLocation());
            }

            if (userDTO.getFullName() != null) {
                todayUser.setFullName(userDTO.getFullName());
                if (userDTO.getEmailId() != null) {
                    todayUser.setEmailId(userDTO.getEmailId());
                    if (userDTO.getPhoneNumber() != null) {
                        todayUser.setPhoneNumber(userDTO.getPhoneNumber());

                        if (userDTO.getPassword() != null) {
                            todayUser.setPassword(userDTO.getPassword());

                            ArrayList<Role> roleArrayList = new ArrayList<>();

                            Role role = roleRepository.findTop1ByRole(Constants.getRole.getStateValue(Constants.getRole.USER));
                            roleArrayList.add(role);

                            todayUser.setRoles(roleArrayList);

                            System.out.println("***********>" + todayUser.toString());

                            userRepository.save(todayUser);
                            return new TodayResponse(HttpStatus.CREATED,
                                    messageSource.getMessage("today.success.title", null, Locale.US),
                                    messageSource.getMessage("today.success.message", null, Locale.US),
                                    "", null);
                        }
                    }
                }
            }
        } else {
            return new TodayResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                    messageSource.getMessage("today.fail", null, Locale.US),
                    messageSource.getMessage("today.fail.message", null, Locale.US),
                    "", null);
        }
        return null;
    }

    @Override
    public TodayResponse saveActivityLog(ActivityActionLogDTO activityActionLogDTO) {

        if (activityActionLogDTO != null) {
            if (activityActionLogDTO.getActivityAnswerDTOList() != null && activityActionLogDTO.getActivityAnswerDTOList().size() > 0) {
                ActivityActionLog activityActionLog = new ActivityActionLog();
                ArrayList<ActivityAnswer> activityAnswerArrayList = new ArrayList<>();
                for (ActivityAnswerDTO activityAnswerDTO : activityActionLogDTO.getActivityAnswerDTOList()) {
                    ActivityAnswer activityAnswer = new ActivityAnswer();
                    activityAnswer.setUserAction(activityAnswerDTO.getUserAction());
                    activityAnswer.setActivityTypeId(activityAnswerDTO.getActivityTypeId());
                    activityAnswer.setActivityTypeDetailId(activityAnswerDTO.getActivityTypeDetailId());
                    activityAnswerRepository.save(activityAnswer);
                    activityAnswerArrayList.add(activityAnswer);
                }
                activityActionLog.setActivityAnswerList(activityAnswerArrayList);
                activityActionLogRepository.save(activityActionLog);
            }
            return new TodayResponse(HttpStatus.CREATED,
                    messageSource.getMessage("today.success.title", null, Locale.US),
                    messageSource.getMessage("today.success.message", null, Locale.US),
                    "", null);
        } else {
            return new TodayResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                    messageSource.getMessage("today.fail", null, Locale.US),
                    messageSource.getMessage("today.fail.message", null, Locale.US),
                    "", null);
        }
    }

    @Override
    public TodayResponse loginUser(String userName, String password) {

        if (userName != null && password != null) {
            TodayUser todayUser = userRepository.findTop1ByEmailIdAndPassword(userName, password);

            if (todayUser != null) {

                if (todayUser.getRoles().size() > 0) {
                    System.out.println("-------------> LOGIN SUCCESS-------ROLE----->" + todayUser.getRoles().get(0).getRole());
                } else {
                    System.out.println("-------------> LOGIN SUCCESS------------->" + todayUser.toString());
                }

                return new TodayResponse(HttpStatus.CREATED,
                        messageSource.getMessage("today.success.title", null, Locale.US),
                        messageSource.getMessage("today.success.message", null, Locale.US),
                        "", null);

            } else {
                return new TodayResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                        messageSource.getMessage("today.fail", null, Locale.US),
                        messageSource.getMessage("today.fail.message", null, Locale.US),
                        "", null);
            }

        } else {
            return new TodayResponse(HttpStatus.INTERNAL_SERVER_ERROR,
                    messageSource.getMessage("today.fail", null, Locale.US),
                    messageSource.getMessage("today.fail.message", null, Locale.US),
                    "", null);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
