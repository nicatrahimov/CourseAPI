package az.coders.CourseAPI.controller;

import az.coders.CourseAPI.dto.GroupDTO;
import az.coders.CourseAPI.model.Group;
import az.coders.CourseAPI.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("group")
public class GroupController {
    @Autowired
    GroupService groupService;
    @GetMapping("/id/{id}")
    public ResponseEntity<GroupDTO>getGroupById(@PathVariable Integer id){
       return groupService.getGroupById(id);
    }
    @GetMapping("/name/{groupName}")
    public ResponseEntity<GroupDTO>getGroupByName(@PathVariable String groupName){
        return groupService.getGroupByGroupName(groupName);
    }
    @GetMapping("/allGroup")
    public ResponseEntity<List<GroupDTO>> getAllGroup() {
        return groupService.getAllGroups();
    }
    @PostMapping("/add")
    public ResponseEntity<String> addGroup(@RequestBody Group group) {
        return groupService.addGroup(group);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editGroup(@RequestBody Group group, @PathVariable Integer id) {
        return groupService.editGroupById(group, id);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGroup(@PathVariable Integer id){
       return groupService.deleteGroupById(id);
    }
}
